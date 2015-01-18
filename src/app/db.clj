(ns app.db
  (:use [korma.db]
        [korma.core])
  (:require [genconfig.db :as config]))

;;; def db
(defdb app-db config/db)
