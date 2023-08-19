package com.castlebell.lingvo.skt.dao.domain.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseReservations implements Serializable {

    // 발신ID
    private UUID bizcallId;

    // 시나리오ID
    private String scenarioId;

    // 시나리오명
    private String scenarioName;

    // 예약자ID (API로 등록한 예약은 존재하지 X)
    private Integer memberId;

    // 예약 우선 순위
    private Integer priority;

    // 보이스
    private Voice voice;

    // 대화 속도
    private Integer voiceSpeed;

    // 비즈콜 이름
    private String bizcallName;

    // 발신 예약 정보
    private ReservationInfo reservationInfo;

    // 재발신 정보
    private Retry retry;

    // 예약발신상태
    private CallStatus callStatus;

    // 원번호
    private String originalMdn;

    // 변경변호
    private String changedMdn;

    // 총 대상자
    private Integer totalRecipientCount;

    // 완료 대상자
    private Integer completionRecipientCount;

    // 생성 시각 (최초 등록일자)
    private LocalDateTime createdDateTime;

    // 변경 시각 (예약 내용이 변경된 일자)
    private LocalDateTime modifiedDateTime;

    // Getters and Setters

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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public Integer getVoiceSpeed() {
        return voiceSpeed;
    }

    public void setVoiceSpeed(Integer voiceSpeed) {
        this.voiceSpeed = voiceSpeed;
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

    public CallStatus getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(CallStatus callStatus) {
        this.callStatus = callStatus;
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

    // Nested Classes

    public static class ReservationInfo {
        private LocalDateTime reservationDateTime;
        private Integer reservationSequence;
        private LocalDateTime doneDateTime;

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

        public LocalDateTime getDoneDateTime() {
            return doneDateTime;
        }

        public void setDoneDateTime(LocalDateTime doneDateTime) {
            this.doneDateTime = doneDateTime;
        }

        @Override
        public String toString() {
            return "ReservationInfo{" +
                    "reservationDateTime=" + reservationDateTime +
                    ", reservationSequence=" + reservationSequence +
                    ", doneDateTime=" + doneDateTime +
                    '}';
        }
    }

    public static class Retry {
        private Integer retryCount;
        private Integer retryInterval;

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

        @Override
        public String toString() {
            return "Retry{" +
                    "retryCount=" + retryCount +
                    ", retryInterval=" + retryInterval +
                    '}';
        }
    }

    public enum Voice {
        TIFFANY,
        ARIA,
        OLIVER
    }

    public enum CallStatus {
        READY,                                  //발신전
        FETCHING,                               //발신 준비
        PROGRESS,                               //발신 진행중
        RETRYING,                               //재발신 진행중
        DONE,                                   //발신 완료
        FAIL,                                   //발신 실패
        STOP,                                   //발신 정지
        NOT_SENT                                //미발신
    }

    @Override
    public String toString() {
        return "RequestReservations{" +
                "bizcallId=" + bizcallId +
                ", scenarioId='" + scenarioId + '\'' +
                ", scenarioName='" + scenarioName + '\'' +
                ", memberId=" + memberId +
                ", priority=" + priority +
                ", voice=" + voice +
                ", voiceSpeed=" + voiceSpeed +
                ", bizcallName='" + bizcallName + '\'' +
                ", reservationInfo=" + reservationInfo +
                ", retry=" + retry +
                ", callStatus=" + callStatus +
                ", originalMdn='" + originalMdn + '\'' +
                ", changedMdn='" + changedMdn + '\'' +
                ", totalRecipientCount=" + totalRecipientCount +
                ", completionRecipientCount=" + completionRecipientCount +
                ", createdDateTime=" + createdDateTime +
                ", modifiedDateTime=" + modifiedDateTime +
                '}';
    }
}