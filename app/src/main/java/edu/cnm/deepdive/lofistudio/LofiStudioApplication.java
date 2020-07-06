package edu.cnm.deepdive.lofistudio;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.lofistudio.service.LofiStudioDatabase;
import io.reactivex.schedulers.Schedulers;

public class LofiStudioApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    LofiStudioDatabase.setContext(this);
    LofiStudioDatabase.getInstance().getPlaylistDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
