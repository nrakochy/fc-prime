(defproject fc-prime "0.1.0-SNAPSHOT"
  :description "Prime number extravaganza"
  :url "https://github.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main fc-prime.main
  :aot :all 
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.20.0"]]}})
