
var script = document.createElement('script');
script.src = `https://maps.googleapis.com/maps/api/js?key=${apiKey}&callback=initAutocomplete&libraries=places&v=weekly`;
script.async = true;
document.head.appendChild(script);


function initAutocomplete() {
    const map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 32.783537699942244, lng: -96.80533222610609 },
        zoom: 13,
        mapTypeId: "roadmap",
    });

    // Create the search box and link it to the UI element.
    const input = document.getElementById("pac-input");
    const searchBox = new google.maps.places.SearchBox(input);

    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
    // Bias the SearchBox results towards current map's viewport.
    map.addListener("bounds_changed", () => {
        searchBox.setBounds(map.getBounds());


    });

    let markers = [];

    function cards(markers) {
        let html = ``;

        markers.forEach((marker) => {
            if (marker.address) {
                html += `<div class="card">
                <div class="card-body">
                  <h5 class="card-title" style="background: navajowhite">
                 <img src=${marker.icon.url} class="card-img-top"  alt="img">
                    ${marker.title}
                  </h5>
                  <hr>
                  <p class="card-address">${marker.address}</p>
                </div>
              </div>`;
        }});

        return html;
    }

    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener("places_changed", () => {
        const places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }

        // Clear out the old markers.
        markers.forEach((marker) => {
            marker.setMap(null);
        });
        markers = [];

        // For each place, get the icon, name and location.
        const bounds = new google.maps.LatLngBounds();

        places.forEach((place) => {
            if (!place.geometry || !place.geometry.location) {
                console.log("Returned place contains no geometry");
                return;
            }

            const icon = {
                url: place.icon,
                size: new google.maps.Size(50, 50),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25),
            };

            // Create a marker for each place.
            const marker = new google.maps.Marker({
                map: map,
                position: place.geometry.location,
                title: place.name,
                icon,
            });

            // Add the marker to the markers array.
            markers.push(marker);

            // Retrieve the address information for the marker.
            const geocoder = new google.maps.Geocoder();
            geocoder.geocode({ location: place.geometry.location }, (results, status) => {
                if (status === "OK") {
                    // Update the marker's address property with the formatted address.
                    marker.address = results[0].formatted_address;

                    // Update the card container with the updated marker information.
                    let cardContainer = document.getElementById("cards");
                    cardContainer.innerHTML = cards(markers);
                } else {
                    console.log(`Geocoder failed due to: ${status}`);
                }

                searchBox.addListener("places_changed", () => {
                    const places = searchBox.getPlaces();

                    // ...

                    // Create a marker and fetch the formatted address for each place.
                    places.forEach((place) => {
                        if (!place.geometry || !place.geometry.location) {
                            console.log("Returned place contains no geometry");
                            return;
                        }

                        const icon = {
                            url: place.icon,
                            size: new google.maps.Size(50, 50),
                            origin: new google.maps.Point(0, 0),
                            anchor: new google.maps.Point(17, 34),
                            scaledSize: new google.maps.Size(25, 25),
                        };

                        // Create a marker for each place.
                        const marker = new google.maps.Marker({
                            map,
                            icon,
                            title: place.name,
                            position: place.geometry.location,
                        });

                        // Fetch the formatted address for the place.
                        const geocoder = new google.maps.Geocoder();
                        geocoder.geocode({location: place.geometry.location}, (results, status) => {
                            if (status === "OK" && results[0]) {
                                const address = results[0].formatted_address;

                                // Add the address to the marker and card.
                                marker.address = address;
                                const card = createCard(marker);
                            } else {
                                console.log("Geocoder failed due to: " + status);
                            }
                        });

                        markers.push(marker);

                        if (place.geometry.viewport) {
                            bounds.union(place.geometry.viewport);
                        } else {
                            bounds.extend(place.geometry.location);
                        }
                    });

                    // ...

                });

                function createCard(marker) {
                    const card = document.createElement("div");
                    card.className = "card";
                    card.style.width = "180px";
                    card.style.height = "fit-content";
                    card.innerHTML = `
    <img src=${marker.icon.url} className="card-img-top" alt="img" style="height: 40px">
    <div class="card-body">
      <h5 class="card-title"> ${marker.title}</h5>
      <p class="card-address">Address: ${marker.address}</p>
    </div>
  `;

                    return card;
                }

            })

})})

}
    window.initAutocomplete = initAutocomplete;
