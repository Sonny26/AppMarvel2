package com.example.appmarvel;

import java.util.List;


public class RestMarvelResponse {

    private Integer count;
    private String next;
    private String previous;
    private List<Marvel> Marvel;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Marvel> getResults() {
        return Marvel;
    }

    public void setResults(List<Marvel> Marvel) {
        this.Marvel = Marvel;
    }
}
