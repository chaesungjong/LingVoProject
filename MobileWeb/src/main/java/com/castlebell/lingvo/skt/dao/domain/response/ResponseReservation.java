package com.castlebell.lingvo.skt.dao.domain.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseReservation implements Serializable {

    // 발신ID
    private UUID bizcallId;

    // 시나리오 ID
    private String scenarioId;

    // 시나리오명
    private String scenarioName;

    // 예약 우선 순위
    private Integer priority;

    // 원번호
    private String originalMdn;

    // 변경번호
    private String changedMdn;

    // 보이스
    private String voice;

    // 대화 속도
    private Integer voiceSpeed;

    // 대화 음량
    private Integer voiceVolume;

    // 비즈콜 이름
    private String bizcallName;

    // 발신 예약 정보
    private ReservationInfo reservationInfo;

    // 예약 상태
    private String callStatus;

    // 재발신 정보
    private Retry retry;

    // 총 대상자
    private Integer totalRecipientCount;

    // 완료 대상자
    private Integer completionRecipientCount;

    // 생성 시각 (최초 등록일자)
    private LocalDateTime createdDateTime;

    // 변경 시각 (예약 내용이 변경된 일자)
    private LocalDateTime modifiedDateTime;

    public static class ReservationInfo {
        // 발신예약 시각
        private LocalDateTime reservationDateTime;

        // 예약별 발신 순서
        private Integer reservationSequence;

        public LocalDateTime getReservationDateTime() {
            return reservationDateTime;
        }

        public void setReservationDateTime(LocalDateTime reservationDateTime) {
            this.reservationDateTime = reservationDateTime;
        }

        public Integer getReservationSequence() {
            return reservationSequence;
        }

        public void setReservationSequence(Integer reservationSequence) {
            this.reservationSequence = reservationSequence;
        }

        @Override
        public String toString() {
            return "ReservationInfo{" +
                    "reservationDateTime=" + reservationDateTime +
                    ", reservationSequence=" + reservationSequence +
                    '}';
        }
    }

    public static class Retry {
        // 재발신 횟수
        private Integer retryCount;

        // 재발신 주기
        private Integer retryInterval;

        // 대리 수신 재발신 여부
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

    public UUID getBizcallId() {
        return bizcallId;
    }

    public void setBizcallId(UUID bizcallId) {
        this.bizcallId = bizcallId;
    }

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Retry getRetry() {
        return retry;
    }

    public void setRetry(Retry retry) {
        this.retry = retry;
    }

    public Integer getTotalRecipientCount() {
        return totalRecipientCount;
    }

    public void setTotalRecipientCount(Integer totalRecipientCount) {
        this.totalRecipientCount = totalRecipientCount;
    }

    public Integer getCompletionRecipientCount() {
        return completionRecipientCount;
    }

    public void setCompletionRecipientCount(Integer completionRecipientCount) {
        this.completionRecipientCount = completionRecipientCount;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    @Override
    public String toString() {
        return "ResponseReservation{" +
                "bizcallId=" + bizcallId +
                ", scenarioId='" + scenarioId + '\'' +
                ", scenarioName='" + scenarioName + '\'' +
                ", priority=" + priority +
                ", originalMdn='" + originalMdn + '\'' +
                ", changedMdn='" + changedMdn + '\'' +
                ", voice='" + voice + '\'' +
                ", voiceSpeed=" + voiceSpeed +
                ", voiceVolume=" + voiceVolume +
                ", bizcallName='" + bizcallName + '\'' +
                ", reservationInfo=" + reservationInfo +
                ", callStatus='" + callStatus + '\'' +
                ", retry=" + retry +
                ", totalRecipientCount=" + totalRecipientCount +
                ", completionRecipientCount=" + completionRecipientCount +
                ", createdDateTime=" + createdDateTime +
                ", modifiedDateTime=" + modifiedDateTime +
                '}';
    }
}