package com.sixin.ztv.recommend.channel.fragments.fragment14.model.bean;

public class MatchBean {
        /**
         * id : 1855
         * match_name : 2019LCS春季赛
         * room_id : 522424
         * video_hash : ZB5Kv9Lbe6bWa93x
         * begin_time : 1550563200
         * score : 0:1
         * status : 3
         * team1_name : CLG
         * team1_logo : https://sta-op.douyucdn.cn/dylamr/2019/02/18/04b03ba6fd084ac0dfd9807f759fcec4.png
         * team2_name : GGS
         * team2_logo : https://sta-op.douyucdn.cn/dylamr/2019/02/18/54187a483b137522a02a0e7f8e32766b.png
         */

        private int id;
        private String match_name;
        private int room_id;
        private String video_hash;
        private int begin_time;
        private String score;
        private int status;
        private String team1_name;
        private String team1_logo;
        private String team2_name;
        private String team2_logo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMatch_name() {
            return match_name;
        }

        public void setMatch_name(String match_name) {
            this.match_name = match_name;
        }

        public int getRoom_id() {
            return room_id;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public String getVideo_hash() {
            return video_hash;
        }

        public void setVideo_hash(String video_hash) {
            this.video_hash = video_hash;
        }

        public int getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(int begin_time) {
            this.begin_time = begin_time;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTeam1_name() {
            return team1_name;
        }

        public void setTeam1_name(String team1_name) {
            this.team1_name = team1_name;
        }

        public String getTeam1_logo() {
            return team1_logo;
        }

        public void setTeam1_logo(String team1_logo) {
            this.team1_logo = team1_logo;
        }

        public String getTeam2_name() {
            return team2_name;
        }

        public void setTeam2_name(String team2_name) {
            this.team2_name = team2_name;
        }

        public String getTeam2_logo() {
            return team2_logo;
        }

        public void setTeam2_logo(String team2_logo) {
            this.team2_logo = team2_logo;
        }

    @Override
    public String toString() {
        return "MatchBean{" +
                "id=" + id +
                ", match_name='" + match_name + '\'' +
                ", room_id=" + room_id +
                ", video_hash='" + video_hash + '\'' +
                ", begin_time=" + begin_time +
                ", score='" + score + '\'' +
                ", status=" + status +
                ", team1_name='" + team1_name + '\'' +
                ", team1_logo='" + team1_logo + '\'' +
                ", team2_name='" + team2_name + '\'' +
                ", team2_logo='" + team2_logo + '\'' +
                '}';
    }
}
