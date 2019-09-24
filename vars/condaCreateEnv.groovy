#!/usr/bin/env groovy
/**
 * Send notifications based on build status string
 */

def call(String env_name, String env_file) {

    def env_definition = libraryResource "gemini/dragons/envs/${env_file}"
    echo "${env_definition}"

    writeFile file: "$env_file", text: "$env_definition"
    sh "ls -lah"
    sh "echo $env_file"

//    sh  """
//        if conda info --envs | grep -q ${env_name}; then
//            echo " Skipping creation of existing conda environment: ${env_name}";
//        else
//            conda env create --quiet --file ${env_file} -n ${env_name};
//        fi
//        """

}
