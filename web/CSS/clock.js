var hour=0,min=0,sec=0;
function formatTime()
{
    var hou="",mi="",se="";
    hour=sessionStorage.h;
    min=sessionStorage.m;
    sec=sessionStorage.s;
    if(hour<10)
        hou="0"+hour;
    else
        hou=hour;
    if(min<10)
        mi="0"+min;
    else
        mi=min;
    if(sec<10)
        se="0"+sec;
    else
        se=sec;
    document.getElementById("clk").value=hou+':'+mi+':'+se;
    if(hour==0&&min==0&&sec==0)
    {
        alert("Time's Up...!!!!");
        window.location="QuizResult";
    }
    if(sec==0)
    {
        sec=59;
        if(min==0)
        {
            min=59;
            if(hour==0)
                hour=0;
            else
                hour-=1;
        }
        else
            min-=1;
    }
    else
        sec-=1;
    sessionStorage.h=hour;
    sessionStorage.m=min;
    sessionStorage.s=sec;
    setTimeout("formatTime()",1000);
}