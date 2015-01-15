(ns core.modelgen
  (:require [clojure.tools.cli :refer [parse-opts]]
            [selmer.parser :as parser]
            [clojure.string :as str]))

(def cli-options
  [["-n" "--name NAME" "Model Name"]
   ["-t" "--table TABLE" "Table Name"]])

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn validate [options errors]
  (cond
   errors (exit 1 (str/join "\n" errors)),
   (not (:name options)) (exit 1 "Please input model name"),
   :else true))

(defn generate-model [options]
  (println (parser/render-file "templates/clj/models/sample_model.clj" options))
  )

(defn -main
  [& args]
  (let [opts (parse-opts args cli-options)
        options (:options opts)
        errors (:errors opts)]

    (println opts)

    (validate options errors)
    (generate-model options)))
