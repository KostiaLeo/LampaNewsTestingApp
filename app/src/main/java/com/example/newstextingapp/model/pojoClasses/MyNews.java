package com.example.newstextingapp.model.pojoClasses;
/*
 * Author - Levitskiy Konstantin
 */
// Typical pojo-class
//(main pojo-class)
public class MyNews {
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
