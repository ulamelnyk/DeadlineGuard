CREATE TABLE tasks (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       deadline TIMESTAMP NOT NULL,
                       created_at TIMESTAMP NOT NULL
);

CREATE TABLE notifications (
                               id BIGSERIAL PRIMARY KEY,
                               task_id BIGINT NOT NULL REFERENCES tasks(id) ON DELETE CASCADE,
                               notify_at TIMESTAMP NOT NULL,
                               status VARCHAR(50) NOT NULL
);