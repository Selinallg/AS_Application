package zhongan.com.bean;

import java.util.List;

/**
 * Created by LiuLiangGuo on 2016/6/19.
 */
public class Bean {


    /**
     * result : SUCCESS
     * files : [{"upload_time":"2015-11-07 12:42:47","cat1_id":1,"status":2,"file_id":1,"cat2_id":1,"file_type":"JPG"},{"upload_time":"2015-11-07 12:42:52","cat1_id":1,"status":2,"file_id":2,"cat2_id":2,"file_type":"JPG"},{"upload_time":"2015-11-07 12:47:23","cat1_id":1,"status":2,"file_id":3,"cat2_id":1,"file_type":"JPG"},{"upload_time":"2015-11-07 12:47:28","cat1_id":1,"status":0,"file_id":4,"cat2_id":2,"file_type":"JPG"},{"upload_time":"2015-11-07 12:47:33","cat1_id":1,"status":1,"file_id":5,"thumb_url":"http://7xnb6d.com1.z0.glb.clouddn.com/thumb/5_683721.jpg?e=1447150227&token=wI1XAFCkN2OC2Ty28BouznH8HJEQvB429QQWpZWB:VPdlcI4TQX53N2-0y9BDhcwgNu0=","cat2_id":1,"file_type":"JPG"},{"upload_time":"2015-11-07 12:51:29","cat1_id":1,"status":1,"file_id":6,"thumb_url":"http://7xnb6d.com1.z0.glb.clouddn.com/thumb/6_234238.jpg?e=1447150227&token=wI1XAFCkN2OC2Ty28BouznH8HJEQvB429QQWpZWB:Bg_1rLcOv0YefrlKZLAQFLWZaz0=","cat2_id":1,"file_type":"JPG"},{"upload_time":"2015-11-07 12:58:35","cat1_id":2,"status":1,"file_id":7,"thumb_url":"http://7xnb6d.com1.z0.glb.clouddn.com/thumb/7_468220.jpg?e=1447150227&token=wI1XAFCkN2OC2Ty28BouznH8HJEQvB429QQWpZWB:h-tqv0FxAm2Tk2CHgQ4GtkPYyAI=","cat2_id":4,"file_type":"JPG"},{"upload_time":"2015-11-07 13:00:00","cat1_id":1,"status":1,"file_id":8,"thumb_url":"http://7xnb6d.com1.z0.glb.clouddn.com/thumb/8_785744.jpg?e=1447150227&token=wI1XAFCkN2OC2Ty28BouznH8HJEQvB429QQWpZWB:iaWnN5YQ9X_-fhISOipzMfzlAig=","cat2_id":2,"file_type":"JPG"},{"upload_time":"2015-11-10 15:56:40","cat1_id":1,"status":1,"file_id":9,"thumb_url":"http://7xnb6d.com1.z0.glb.clouddn.com/thumb/9_527462.jpg?e=1447150227&token=wI1XAFCkN2OC2Ty28BouznH8HJEQvB429QQWpZWB:2IcRLI6f33B4p4WHEYYtpla6au0=","cat2_id":1,"file_type":"JPG"}]
     * comment : ok
     * success : true
     */
    private String result;
    private List<FilesEntity> files;
    private String comment;
    private boolean success;

    public void setResult(String result) {
        this.result = result;
    }

    public void setFiles(List<FilesEntity> files) {
        this.files = files;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public List<FilesEntity> getFiles() {
        return files;
    }

    public String getComment() {
        return comment;
    }

    public boolean isSuccess() {
        return success;
    }

    public class FilesEntity {
        /**
         * upload_time : 2015-11-07 12:42:47
         * cat1_id : 1
         * status : 2
         * file_id : 1
         * cat2_id : 1
         * file_type : JPG
         */
        private String upload_time;
        private int cat1_id;
        private int status;
        private int file_id;
        private int cat2_id;
        private String file_type;

        public void setUpload_time(String upload_time) {
            this.upload_time = upload_time;
        }

        public void setCat1_id(int cat1_id) {
            this.cat1_id = cat1_id;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setFile_id(int file_id) {
            this.file_id = file_id;
        }

        public void setCat2_id(int cat2_id) {
            this.cat2_id = cat2_id;
        }

        public void setFile_type(String file_type) {
            this.file_type = file_type;
        }

        public String getUpload_time() {
            return upload_time;
        }

        public int getCat1_id() {
            return cat1_id;
        }

        public int getStatus() {
            return status;
        }

        public int getFile_id() {
            return file_id;
        }

        public int getCat2_id() {
            return cat2_id;
        }

        public String getFile_type() {
            return file_type;
        }
    }
}
