$(window).load(function(){
  $("td").val("");
  $("input").focusout(function(){
    if($(this).val() != ""){
      $(this).addClass("has-content");
    }else{
    $(this).removeClass("has-content");
    }
  });
});