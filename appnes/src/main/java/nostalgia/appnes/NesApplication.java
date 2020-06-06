package nostalgia.appnes;

import android.content.Intent;

import nostalgia.framework.AdActivity;
import nostalgia.framework.BaseApplication;
import nostalgia.framework.base.EmulatorHolder;


public class NesApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        //
        //added ads on game startup...
        Intent ads = new Intent(this, AdActivity.class);//
        ads.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ads);
        //

        EmulatorHolder.setEmulatorClass(NesEmulator.class);
    }

    @Override
    public boolean hasGameMenu() {
        return true;
    }
}
