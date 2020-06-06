package nostalgia.appgg;

import android.content.Intent;

import java.util.HashSet;
import java.util.Set;

import nostalgia.framework.AdActivity;
import nostalgia.framework.Emulator;
import nostalgia.framework.base.EmulatorActivity;
import nostalgia.framework.ui.gamegallery.GalleryActivity;

public class GGGalleryActivity extends GalleryActivity {

    @Override
    public Emulator getEmulatorInstance() {
        return GGEmulator.getInstance();
    }

    @Override
    public Class<? extends EmulatorActivity> getEmulatorActivityClass() {
        return GGEmulatorActivity.class;
    }

    @Override
    protected Set<String> getRomExtensions() {
        HashSet<String> set = new HashSet<>();
        set.add("gg");
        return set;
    }
    public void onBackPressed() {
        super.onBackPressed();

        //added ads on game exit...
        Intent ads = new Intent(this, AdActivity.class);//
        ads.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ads);
    }
}
