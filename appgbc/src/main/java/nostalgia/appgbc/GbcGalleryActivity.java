package nostalgia.appgbc;

import android.content.Intent;

import java.util.HashSet;
import java.util.Set;

import nostalgia.framework.AdActivity;
import nostalgia.framework.Emulator;
import nostalgia.framework.base.EmulatorActivity;
import nostalgia.framework.ui.gamegallery.GalleryActivity;

public class GbcGalleryActivity extends GalleryActivity {

    @Override
    public Class<? extends EmulatorActivity> getEmulatorActivityClass() {
        return GbcEmulatorActivity.class;
    }

    @Override
    protected Set<String> getRomExtensions() {
        HashSet<String> set = new HashSet<>();
        set.add("gb");
        set.add("gbc");
        return set;
    }

    @Override
    public Emulator getEmulatorInstance() {
        return GbcEmulator.getInstance();
    }

    public void onBackPressed() {
        super.onBackPressed();

        //added ads on game exit...
        Intent ads = new Intent(this, AdActivity.class);//
        ads.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ads);
    }
}
