/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package merocrawler;

/**
 *
 * @author asish
 */
class InfiniteLoop implements Runnable{
    private boolean stopOrNot=false;
    CrawlerBaseObj[] myArray;

    public InfiniteLoop(CrawlerBaseObj[] myArray) {
        this.myArray = myArray;
    }

    
    
  @Override
  public void run() {
    long sum = 0;
    try{
    while(stopOrNot==false)
    {
       
       Thread.currentThread().sleep(500);
       sum++;
    }
    }
    catch(InterruptedException e)
            {
                
            }
  }
  public void stopper(boolean value)
  {
      stopOrNot= true;
  }
} 