第一题phone number to words. 被怀疑刷过题，如实回答后直接进入第二题。

design hit logger, return number of hits in last 5 mins.

看到有人被问到这题，大概思路对了，用的rotation array， 但在清空的环节上卡住
了。 哎，还是大意了。
感觉面试的题还是很tricky的。


class logger{
     vector<int> hits(300);
     long startTime;
     long lastTimeCalled;
  public:
     logger() {
       lastTimeCalled = -1;
       startTime = time();
     }
 
     void zeroOut(int lapsed) {
          int lastPos = lastTimeCalled % 300;
          if(lapsed >＝ 300) {
            for(int i = 0; i < hits.size(); i++) {
              hits[i] = 0;
            }
          } else if(lastTimeCalled != -1){
            for(int i = lastPos + 1; i < lastPos + lapsed; i++) {//this part is important
            // here it tells, say lastPos =60; cur = 350; 
            // betwen time window 60--350: no body hit; so clear them
            // clear is divided by two parts: i). i < 300; i.e. 60--299
            //                               ii). i >=300; i.e. 300--349 => 0---49
              hits[i % 300] = 0;          // iii). the only thing get counted is <50,60>
            }
          }      
     }
 
     void logHit() {
          long curTime = time() - startTime;
          long lapsed = curTime - lastTimeCalled;
          zeroOut(lapsed);
          curSecond = curTime % 300;
         
          if(curSecond == lastTimeCalled % 300) { //if concurrent hit; then ++
               hits[curSecond]++;
          } else {
               hits[curSecond] = 1;     //if not concurrent hit, then new hit will reset old to 1//
          }
          lastTimeCalled = curTime;
     }
 
     int getHitLastFiveMin() {
         // need to do similar things here
          long curTime = time() - startTime;

          long lapsed = curTime - lastTimeCalled;
          zeroOut(lapsed);
          lastTimeCalled = curTime;     
          int res = 0;
          for(int i = 0; i < hits.size(); i++) {
               res += hits[i];
          }
          return res;
     }
}
