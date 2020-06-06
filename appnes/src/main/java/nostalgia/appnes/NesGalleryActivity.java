package nostalgia.appnes;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import nostalgia.framework.AdActivity;
import nostalgia.framework.Emulator;
import nostalgia.framework.base.EmulatorActivity;
import nostalgia.framework.base.OpenGLTestActivity;
import nostalgia.framework.ui.gamegallery.GalleryActivity;
import nostalgia.framework.ui.preferences.PreferenceUtil;
import nostalgia.framework.utils.EmuUtils;
import nostalgia.framework.utils.NLog;/////////////


public class NesGalleryActivity extends GalleryActivity {
    //private InterstitialAd mInterstitialAd;//our ad

    private static final int REQUEST_CHECK_OPENGL = 200;

    @Override
    public Emulator getEmulatorInstance() {
        return NesEmulator.getInstance();
    }

    @Override
    public Class<? extends EmulatorActivity> getEmulatorActivityClass() {
        return NesEmulatorActivity.class;
    }

    @Override
    protected Set<String> getRomExtensions() {
        HashSet<String> set = new HashSet<>();
        set.add("nes");
        set.add("fds");
        return set;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (PreferenceUtil.getFragmentShader(this) == -1
                && EmuUtils.checkGL20Support(this)) {
            Intent intent = new Intent(this, OpenGLTestActivity.class);
            startActivityForResult(intent, REQUEST_CHECK_OPENGL);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHECK_OPENGL) {
            NLog.e("opengl", "opengl: " + resultCode);
            PreferenceUtil.setFragmentShader(this, resultCode);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();

        //added ads on game exit...
        Intent ads = new Intent(this, AdActivity.class);//
        ads.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ads);
    }
}
