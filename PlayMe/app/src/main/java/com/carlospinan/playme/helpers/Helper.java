package com.carlospinan.playme.helpers;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;

import com.carlospinan.playme.models.AudioModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Piñan
 */
public class Helper {

    private Helper() { /* UNUSED */ }

    public static List<AudioModel> getAudios(Context context) {
        List<AudioModel> audioModelList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(getStringFromAsset(context, Globals.PATH_CONTENT_JSON));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                AudioModel audioModel = new AudioModel();
                audioModel.setAudio(object.getString("audio"));
                audioModel.setDescription(object.getString("description"));
                audioModel.setTitle(object.getString("title"));
                audioModel.setBitmap(object.getString("bitmap"));
                audioModelList.add(audioModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return audioModelList;
    }

    public static String getStringFromAsset(Context context, String path) {
        StringBuilder result = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                result.append(string);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static MediaPlayer getMediaPlayer(Context context, String file) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor afd = context.getAssets().openFd(Globals.BASE_PATH_AUDIOS + file);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public static Bitmap getBitmapFromAsset(Context context, String filePath) {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            inputStream = assetManager.open(Globals.BASE_PATH_BITMAPS + filePath);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
