(ns pivotal-tracker.client
  (:require [clj-http.client :as client]
            [pivotal-tracker.xml :as xml]))

(defn- request [f token path query-params]
  (println (str "Requesting " path))
  (xml/simple-parse
    (:body
      (f (str "https://www.pivotaltracker.com/services/v3" path)
         {:headers {"X-TrackerToken" token}
          :query-params query-params}))))


(defn- get-request
  ([token path]
    (get-request token path {}))
  ([token path query-params]
    (request client/get token path query-params)))

(defn projects [token]
  (map :project
    (:projects
      (get-request token "/projects"))))

(defn project [token id]
  (:project
    (get-request token (str "/projects/" id))))

(defn stories
  ([token project-id]
    (stories token project-id {}))
  ([token project-id query-params]
    (map :story
      (:stories
        (get-request token (str "/projects/" project-id "/stories") query-params)))))
