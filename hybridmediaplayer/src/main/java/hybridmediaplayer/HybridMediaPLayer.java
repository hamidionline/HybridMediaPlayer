package hybridmediaplayer;

import android.content.Context;

public abstract class HybridMediaPLayer {
    OnPreparedListener onPreparedListener = null;
    OnCompletionListener onCompletionListener = null;
    OnErrorListener onErrorListener = null;

    public static HybridMediaPLayer getInstance(Context context) {
        HybridMediaPLayer res;
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            res = new ExoMediaPlayer(context);
        } else {
            res = new AndroidMediaPlayer(context);
        }
        return res;
    }

    public abstract void setDataSource(String path);

    public abstract void prepare();

    public abstract void play();

    public abstract void pause();

    public abstract void seekTo(int msec);

    public abstract int getDuration();

    public abstract int getCurrentPosition();

    public abstract boolean isPlaying();

    public abstract void release();

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.onPreparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public interface OnPreparedListener {
        void onPrepared(HybridMediaPLayer player);
    }

    public interface OnCompletionListener {
        void onCompletion(HybridMediaPLayer player);
    }

    public interface OnErrorListener {
        void onError(HybridMediaPLayer player);
    }
}