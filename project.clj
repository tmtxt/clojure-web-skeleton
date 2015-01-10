(defproject skeleton "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.nrepl "0.2.6"]
                 [compojure "1.3.1"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [selmer "0.7.9"]
                 [lib-noir "0.9.5"]
                 [korma "0.4.0"]
                 [org.postgresql/postgresql "9.3-1100-jdbc41"]
                 [log4j "1.2.15" :exclusions [javax.mail/mail
                                              javax.jms/jms
                                              com.sun.jdmk/jmxtools
                                              com.sun.jmx/jmxri]]]

  :plugins [[lein-ring "0.8.12"]]

  :ring {:handler app.handler/app
         :init app.handler/init
         :destroy app.handler/destroy}

  :main core.runner

  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.2"]]
    :ring
    {:open-browser? false}}})
