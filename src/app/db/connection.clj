(ns app.db.connection
  (:use [korma.db]
        [korma.core])
  (:require [app.db.config :as config]))

;;; def db
(defdb app-db config/db)
