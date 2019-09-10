#!/usr/bin/env groovy

package gemini.dragons.build


class CondaRecipe implements Serializable {

    private String _url
    private String _filename

    CondaRecipe(String url, String filename) {
        _url = url
        _filename = filename
    }

    void download() {

        println "Hello World"

    }

}