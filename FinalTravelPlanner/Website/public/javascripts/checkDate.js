function checkDate(){
    var startDay=new Date($("#departure_date").val());
    var endDay=new Date($("#arrival_date").val());
    var days=endDay.getTime()-startDay.getTime();
    days=parseInt(days/(1000*60*60*24)-1);
    if(days<=0){
        alert('The difference between departure day and arrival day is at least three days!');
    }

}