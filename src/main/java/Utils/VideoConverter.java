package Utils;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.File;
import java.io.IOException;

public class VideoConverter {

    private static final String FFMPEG_PATH = "C:\\Users\\WChainan\\Downloads\\ffmpeg-7.1-essentials_build\\ffmpeg-7.1-essentials_build\\bin\\ffmpeg.exe";
    private static final String FFPROBE_PATH = "C:\\Users\\WChainan\\Downloads\\ffmpeg-7.1-essentials_build\\ffmpeg-7.1-essentials_build\\bin\\ffprobe.exe";

    public static void convertAviToMp4(File source, File target) throws IOException {
        FFmpeg ffmpeg = new FFmpeg(FFMPEG_PATH);
        FFprobe ffprobe = new FFprobe(FFPROBE_PATH);

        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(source.getAbsolutePath())
                .overrideOutputFiles(true)
                .addOutput(target.getAbsolutePath())
                .setFormat("mp4")
                .disableSubtitle()
                .setAudioCodec("aac")
                .setVideoCodec("libx264")
                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();
    }
}
