// PARSE THROUGH HTML TO CREATE EVENT OBJECTS,

var eventDivs = $(".event-group");
var eventBucket = [];

eventDivs.each(function (index) {
    var eventId = $(this).children().eq(0);
    var title = $(this).children().eq(1);
    var description = $(this).children().eq(2);
    var date = $(this).children().eq(3);

    var event = {
        "id": eventId.val(),
        "title": title.val(),
        "description": description.val(),
        "start": date.val()
    };

    eventBucket.push(event);
});

document.addEventListener('DOMContentLoaded', function() {
    let calendarEl = document.getElementById('calendar');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay',
            themeSystem: 'bootstrap',
            bootstrapTheme: 'superhero'
        },
        // THEN USE ARRAY TO POPULATE EVENTS ON CALENDAR
        events: eventBucket,
        eventClick: function(info) {
            // show modal with event details
            var modal = $("#eventModal");
            modal.find(".modal-title").text(info.event.title);
            modal.find(".modal-body").text(info.event.extendedProps.description);
            modal.modal("show");
        }
    });

    
    calendar.render();
});

$(document).ready(function() {
    $("#eventModal").modal({
        show: false
    });
});
