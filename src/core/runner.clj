(ns core.runner
  (:require [app.repl :as web-server]
            [clojure.tools.nrepl.server :as repl-server]))

(def nrepl-port 7888)

(defn -main
  [& args]
  (web-server/start-server "3000")
  (repl-server/start-server :port nrepl-port)
  (println (str "nRepl server running on port " nrepl-port)))
