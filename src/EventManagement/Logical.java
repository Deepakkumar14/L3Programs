package EventManagement;

import java.util.ArrayList;

public class Logical {
    public static int startTime=540;
    public static  ArrayList<String > finalEvent=new ArrayList<>();
    public static  ArrayList<String > rejected=new ArrayList<>();
    public static int k=2;

    public ArrayList<String> getTime(ArrayList<String> initialList) {
        finalEvent.add("Track  1");
        for (int i=0;i<initialList.size();i++){
            String event=initialList.get(i);
            String[] array=event.split("\\s");
              int time= calculateTime(array[array.length-1]);
                     String output=setEvent(event,time);
                     if(!(output.equalsIgnoreCase("false"))){
                         initialList.remove(i);
                         i=-1;
                    }
            System.out.println(initialList.size());
        }
        return finalEvent;
    }
    public int calculateTime(String time){
        int number=0;
        if(time.equalsIgnoreCase("lightning")){
            number=5;
        }
        else{
        number=Integer.parseInt(time.replaceAll("[^0-9]",""));
        }
        return number;
    }

    public String timeFormat(int time){
        int hour=time/60;
        int minute=time%60;
        String minutes=minute+"";
        if(minute<10){
            minutes="0"+minutes;
        }
        if(hour>12){
            hour=hour%12;
            return hour+":"+minutes+"PM";
        }
        if(hour==12){
            return hour+":"+minutes+"PM";
        }
        return hour+":"+minutes+"AM";
    }


       public String setEvent(String event, int time){
        if(time+startTime<=720 || (time+startTime>780 && time+startTime<=1020)){
           String finalTime = timeFormat(startTime);
           String output=finalTime+"  "+event;
            startTime=time+startTime;
           finalEvent.add(output);
            return output;
        }else {
            if (startTime == 720) {
                String finalTime = timeFormat(startTime);
                String output = finalTime + "   " + "Lunch";
                startTime = 60 + startTime;
                finalEvent.add(output);
                return "false";
            }
           else if(startTime>960 && startTime<=1020){
                String finalTime = timeFormat(startTime);
                String output1 = finalTime + "   " + "NetworkEvent";
                startTime = 540;
                finalEvent.add(output1);
                finalEvent.add("Track "+k);
                k++;
                return "false";
            }
        }
           return "false";
       }
}

//7
//        a 60min
//        b 45min
//        c 30min
//        d 45min
//        e 45min
//        f lightning
//        g 60min
//         h 45min
//      i 30min
//      j 30min
//      k 45min

//18
//        a 60min
//        b 45min
//        c 30min
//        d 30min
//        e 45min
//        g 60min
//        h 45min
//        i 30min
//        j 30min
//        k 45min
//        l 60min
//        m 60min
//        n 45min
//        o 30min
//        p 30min
//        q 60min