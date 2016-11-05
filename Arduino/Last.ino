#include<LiquidCrystal.h>

int RLED = 13; // RLED 연결핀
int GLED = 11; // GLED 연결핀
int BLED = 10; // BLED 연결핀
//int inputPin = 9; // 센서 시그널핀
int BUTTON = 8; //BUTTON핀
int pirState = LOW; // PIR 초기상태
int val = 0; // Signal 입력값
#define TRIG_PIN 9
#define ECHO_PIN 1
 
LiquidCrystal lcd(2,3,4,5,6,7);

boolean lastButton=LOW;
boolean currentButton=LOW;
boolean ledOn=false;

void setup() {
    pinMode(TRIG_PIN, OUTPUT); 
    pinMode(ECHO_PIN, INPUT);
    pinMode(RLED, OUTPUT); // RLED Output 설정
    pinMode(GLED, OUTPUT); // GLED Output 설정
    pinMode(BLED, OUTPUT); // GLED Output 설정
//    pinMode(inputPin, INPUT); // 센서 Input 설정
    pinMode(BUTTON, INPUT); //BUTTON 입력으로 설정

    lcd.begin(16, 2);
    lcd.print("Studying Hard");
    
    //Serial.begin(9600);
}

boolean debounce(boolean last)
{
    boolean current=digitalRead(BUTTON);
    if(last!=current)
    {
     delay(5);
     current = digitalRead(BUTTON);    
    }  
    return current;
}

void loop(){ 

  int distance = 0;  
 
  digitalWrite(TRIG_PIN, HIGH);
  delay(100); 
  digitalWrite(TRIG_PIN, LOW); 
  distance = pulseIn(ECHO_PIN, HIGH)/58.2; /* 센치미터(cm) */
  
    currentButton = debounce(lastButton);
    if(lastButton==LOW&&currentButton==HIGH)
    {
        ledOn=!ledOn;  
    }
    lastButton=currentButton;
    if(ledOn)
    {
        digitalWrite(GLED,ledOn);
        digitalWrite(RLED, LOW);
        digitalWrite(BLED, LOW);

        for(int time=0; time<6; time++)
       {
          currentButton = debounce(lastButton);
    if(lastButton==LOW&&currentButton==HIGH)
    {
        ledOn=false;
    }
    lastButton=currentButton;
          delay(1000);
          lcd.clear();
          lcd.setCursor(0,1);
          lcd.print(time);
          lcd.setCursor(3,1);
          lcd.print("seconds");
         
           if(time == 5)
         {
          ledOn=false;
          }
       }
    }    
//    val = digitalRead(inputPin); // 센서값 읽기
    
    if (distance <= 10 &&ledOn==false) { // 인체감지시
        digitalWrite(RLED,HIGH); // LED ON
        digitalWrite(BLED,LOW);
        digitalWrite(GLED,LOW);

        
        lcd.setCursor(0,1);
        lcd.print("Seat is occupied");

        if (pirState == LOW) {
            // 시리얼모니터에 메시지 출력
            Serial.println("Motion detected!");
             pirState = HIGH;
        }
        //delay(7000);     
    } 
    if(distance >10&&ledOn==false) {
        digitalWrite(RLED,LOW); // LED ON
        digitalWrite(BLED,HIGH);
        digitalWrite(GLED,LOW);

        lcd.setCursor(0,1);

        lcd.print("Seat is empty   ");
        
        if (pirState == HIGH){        
            // 시리얼모니터에 메시지 출력            
            Serial.println("Motion ended!");
            pirState = LOW;
        }
    }

}

