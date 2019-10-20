package com.example.lampanewstextingapp.model.pojoClasses;

public class MyNews {
//        @SerializedName("next")
//        @Expose
        private String next;
        private Results[] results;

        public String getNext () {
            return next;
        }

        public void setNext (String next) {
            this.next = next;
        }

        public Results[] getResults () {
            return results;
        }

        public void setResults (Results[] results) {
            this.results = results;
        }

        @Override
        public String toString() {
            return "ClassPojo [next = "+next+", results = "+results+"]";
        }
    }
