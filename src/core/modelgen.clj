(ns core.modelgen
  (:require [clojure.tools.cli :refer [parse-opts]]
            [selmer.parser :as parser]))

(def cli-options
  [["-n" "--name NAME" "Model Name"]])

(defn -main
  [& args]
  (def opts (parse-opts args cli-options))
  (println opts)
  (println (parser/render-file "templates/clj/models/sample_model.clj" {:name "hello"})))
