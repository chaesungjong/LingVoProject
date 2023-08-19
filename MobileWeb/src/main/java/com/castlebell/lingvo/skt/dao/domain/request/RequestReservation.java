package com.castlebell.lingvo.skt.dao.domain.request;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RequestReservation implements Serializable {

    // 시나리오ID (필수)
    private String scenarioId;

    // 원번호 (필수)
    private String originalMdn;

    // 변경번호
    private String changedMdn;

    // 우선순위
    private Integer priority;

    // 보이스 (필수)
    private String voice;

    // 대화 속도
    private Integer voiceSpeed;

    // 대화 음량
    private Integer voiceVolume;

    // 비즈콜 이름
    private String bizcallName;

    // 발신 예약 정보
    private ReservationInfo reservationInfo;

    // 재발신 정보
    private Retry retry;

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getOriginalMdn() {
        return originalMdn;
    }

    public void setOriginalMdn(String originalMdn) {
        this.originalMdn = originalMdn;
    }

    public String getChangedMdn() {
        return changedMdn;
    }

    public void setChangedMdn(String changedMdn) {
        this.changedMdn = changedMdn;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public Integer getVoiceSpeed() {
        return voiceSpeed;
    }

    public void setVoiceSpeed(Integer voiceSpeed) {
        this.voiceSpeed = voiceSpeed;
    }

    public Integer getVoiceVolume() {
        return voiceVolume;
    }

    public void setVoiceVolume(Integer voiceVolume) {
        this.voiceVolume = voiceVolume;
    }

    public String getBizcallName() {
        return bizcallName;
    }

    public void setBizcallName(String bizcallName) {
        this.bizcallName = bizcallName;
    }

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public Retry getRetry() {
        return retry;
    }

    public void setRetry(Retry retry) {
        this.retry = retry;
    }

    @Override
    public String toString() {
        return "RequestReservation{" +
                "scenarioId='" + scenarioId + '\'' +
                ", originalMdn='" + originalMdn + '\'' +
                ", changedMdn='" + changedMdn + '\'' +
                ", priority=" + priority +
                ", voice='" + voice + '\'' +
                ", voiceSpeed=" + voiceSpeed +
                ", voiceVolume=" + voiceVolume +
                ", bizcallName='" + bizcallName + '\'' +
                ", reservationInfo=" + reservationInfo +
                ", retry=" + retry +
                '}';
    }

    public static class ReservationInfo {
        // 발신예약 날짜 (필수)
        private LocalDateTime reservationDateTime;

        public LocalDateTime getReservationDateTime() {
            return reservationDateTime;
        }

        public void setReservationDateTime(LocalDateTime reservationDateTime) {
            this.reservationDateTime = reservationDateTime;
        }

        @Override
        public String toString() {
            return "ReservationInfo{" +
                    "reservationDateTime=" + reservationDateTime +
                    '}';
        }
    }

    public static class Retry {
        // 재발신 횟수 (0, 1, 2) (필수)
        private Integer retryCount;

        // 재발신 주기(분) (0, 10, 20) (필수)
        private Integer retryInterval;

        // 대리 수신 재발신 여부 (필수)
        private Boolean replacedRetry;

        public Integer getRetryCount() {
            return retryCount;
        }

        public void setRetryCount(Integer retryCount) {
            this.retryCount = retryCount;
        }

        public Integer getRetryInterval() {
            return retryInterval;
        }

        public void setRetryInterval(Integer retryInterval) {
            this.retryInterval = retryInterval;
        }

        public Boolean getReplacedRetry() {
            return replacedRetry;
        }

        public void setReplacedRetry(Boolean replacedRetry) {
            this.replacedRetry = replacedRetry;
        }

        @Override
        public String toString() {
            return "Retry{" +
                    "retryCount=" + retryCount +
                    ", retryInterval=" + retryInterval +
                    ", replacedRetry=" + replacedRetry +
                    '}';
        }
    }
}