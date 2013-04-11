(ns pivotal-tracker.client
  (:require [clj-http.client :as client]
            [pivotal-tracker.xml :as xml]))

(defn- request [f token path]
  (println (str "Requesting " path))
  (xml/simple-parse
    (:body
      (f (str "https://www.pivotaltracker.com/services/v3" path)
         {:headers {"X-TrackerToken" token}}
         {:accept :json}))))

(defn- get-request [token path]
  (request client/get token path))

(defrecord Project [id])

(defn projects [token]
  (map :project
    (:projects
      (get-request token "/projects"))))

(defn project [token id]
  (:project
    (get-request token (str "/projects/" id))))
