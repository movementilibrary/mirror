package br.com.dasa.mirror.api.model.from.to.admission;

public class Request {

    public enum CurrentSituation {
        SEND_SUCCESS, SEND_ERROR
    }

    private CurrentSituation currentSituation;

    public Request() {
    }

    public Request(CurrentSituation currentSituation) {
        this.currentSituation = currentSituation;
    }

    public CurrentSituation getCurrentSituation() {
        return currentSituation;
    }

    public void setCurrentSituation(CurrentSituation currentSituation) {
        this.currentSituation = currentSituation;
    }
}
