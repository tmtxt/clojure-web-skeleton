(ns core.modelgen
  (:require [clojure.tools.cli :refer [parse-opts]]
            [selmer.parser :as parser]))

(def cli-options
  [["-n" "--name"]])

(defn -main
  [& args]

  (println (parser/render-file "templates/clj/models/sample_model.clj" {:name "hello"})))
