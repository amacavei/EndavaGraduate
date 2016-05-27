var socket = io.connect('http://localhost');

socket.on('news', function (data) {
  console.log(data);
});



$(function() {
$('#toggle-event').change(function() {
  var checked = $(this).prop('checked');

  if(checked){

  $(".row").show();
  $("#chartContainer").hide();
  $("#chartContainerWind").hide();
  $("#chartContainerGear").hide();

  $('.servobtn').button();

  $('.servobtn').on('change',function(){
      console.log("Setting Servo Pos:",$('input[name=servo]:checked').val())
      socket.emit('servo',{pos:$('input[name=servo]:checked').val()});
  });

  console.log(checked);

  $('#ledSet').on('click',function(){
    var tmp = parseInt($('#ledDelay').val(),10);
    console.log("Setting LED Delay:",tmp)
    socket.emit('led',{delay:tmp});
  });
  }else{
    $(".row").hide();
    $("#chartContainer").show();
    $("#chartContainerWind").show();
    $("#chartContainerGear").show();
    console.log('automatic control');
  }

});
});
