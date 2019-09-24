#!/usr/bin/env groovy
/**
 * Send notifications based on build status string
 */

def call(String env_name, String env_file) {

    def env_definition = libraryResource "gemini/dragons/envs/${env_file}"
//    File conda_file = new File("${env_file}")
//    conda_file.write env_definition

//    sh  """
//        if conda info --envs | grep -q ${env_name}; then
//            echo " Skipping creation of existing conda environment: ${env_name}";
//        else
//            conda env create --quiet --file ${env_file} -n ${env_name};
//        fi
//        """

}
