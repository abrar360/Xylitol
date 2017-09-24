package com.abrar.xylitol;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.WindowManager;
import android.widget.ImageView;

import com.abrar.xylitol.MockLockScreeen;
/**
 * Created by abrar_000 on 9/11/2016.
 */
public class Shutdown extends Thread{
    ImageView imagee = MockLockScreeen.img;
    ProgressDialog progdi = MockLockScreeen.pd;
    Vibrator vib = MockLockScreeen.vibe;
    PowerManager mangy = MockLockScreeen.manager;
    MockLockScreeen screen = new MockLockScreeen();

    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        progdi.dismiss();
        vib.vibrate(500);

        screen.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This code will always run on the UI thread, therefore is safe to modify UI elements.
                imagee.setImageBitmap(null);
            }
        });

        //mangy.goToSleep(int amountOfTime);

        //PowerManager.WakeLock wl = mangy.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Your Tag");
        //wl.acquire();
        //wl.release();

    }
}
