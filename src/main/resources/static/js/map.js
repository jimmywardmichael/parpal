window.addEventListener('DOMContentLoaded', () => {
    const script = document.createElement('script');
    script.src = `https://maps.googleapis.com/maps/api/js?key=${apiKey}&callback=initAutocomplete&libraries=places&v=weekly`;
    script.async = true;
    document.head.appendChild(script);
});

function initAutocomplete() {
    const map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 32.7835, lng: -96.8053 },
        zoom: 13,
        mapTypeId: "roadmap"
    });

    const input = document.getElementById("pac-input");
    const searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    let markers = [];

    function createCard(marker) {
        return `
            <div class="card m-2" style="width: 18rem;">
                <img src="${marker.icon.url}" class="card-img-top" alt="icon" style="height: 40px;">
                <div class="card-body">
                    <h5 class="card-title">${marker.title}</h5>
                    <p class="card-text">${marker.address}</p>
                </div>
            </div>
        `;
    }

    searchBox.addListener("places_changed", () => {
        const places = searchBox.getPlaces();
        if (!places || places.length === 0) return;

        markers.forEach(marker => marker.setMap(null));
        markers = [];

        const bounds = new google.maps.LatLngBounds();

        places.forEach(place => {
            if (!place.geometry || !place.geometry.location) return;

            const icon = {
                url: place.icon,
                size: new google.maps.Size(50, 50),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25),
            };

            const marker = new google.maps.Marker({
                map,
                icon,
                title: place.name,
                position: place.geometry.location,
            });

            const geocoder = new google.maps.Geocoder();
            geocoder.geocode({ location: place.geometry.location }, (results, status) => {
                if (status === "OK" && results[0]) {
                    marker.address = results[0].formatted_address;
                    document.getElementById("cards").innerHTML += createCard(marker);
                }
            });

            markers.push(marker);

            if (place.geometry.viewport) {
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });

        map.fitBounds(bounds);
    });
}

window.initAutocomplete = initAutocomplete;