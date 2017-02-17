
$(document).ready(function(){
  $('#sidebar').affix({
      offset: {
        top: 240
      }
});

$('.ticker').ticker();
});



$( ".event-type-select" ).change(function() {
  var selectedEventType = this.options[this.selectedIndex].value;
  if (selectedEventType == "all") {
    $('.contenu div').removeClass('hidden');
  } else {
    $('.contenu div').addClass('hidden');
    $('.contenu div[data-eventtype="' + selectedEventType + '"]').removeClass('hidden');
  }
});
