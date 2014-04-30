import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 * Created by vladislav on 30.04.14.
 */
public class Inform extends TimerTask {

    private View vw ;
    private Timer timer;
    public Inform(View view, java.util.Timer timer){
        vw = view;
        this.timer = timer;
    }
    @Override
    public void run() {
        vw.showMsg();
        timer.cancel();
    }
}
