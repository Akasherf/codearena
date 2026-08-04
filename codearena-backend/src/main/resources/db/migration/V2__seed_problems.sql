-- Two Sum
WITH new_problem AS (
    INSERT INTO problems (title, description, difficulty, tags)
    VALUES (
        'Two Sum',
        'Given an array of integers nums and an integer target, return indices of the two numbers that add up to target. Assume exactly one solution exists.',
        'EASY',
        ARRAY['array', 'hash-table']
    )
    RETURNING id
)
INSERT INTO test_cases (problem_id, input, expected_output, is_hidden)
SELECT id, '[2,7,11,15]|9', '[0,1]', false FROM new_problem
UNION ALL
SELECT id, '[3,2,4]|6', '[1,2]', false FROM new_problem
UNION ALL
SELECT id, '[3,3]|6', '[0,1]', true FROM new_problem;

-- Valid Parentheses
WITH new_problem AS (
    INSERT INTO problems (title, description, difficulty, tags)
    VALUES (
        'Valid Parentheses',
        'Given a string containing only the characters ()[]{}, determine if the input is valid — every open bracket is closed by the same type in the correct order.',
        'EASY',
        ARRAY['string', 'stack']
    )
    RETURNING id
)
INSERT INTO test_cases (problem_id, input, expected_output, is_hidden)
SELECT id, '()', 'true', false FROM new_problem
UNION ALL
SELECT id, '()[]{}', 'true', false FROM new_problem
UNION ALL
SELECT id, '(]', 'false', true FROM new_problem;

-- Reverse Linked List
WITH new_problem AS (
    INSERT INTO problems (title, description, difficulty, tags)
    VALUES (
        'Reverse Linked List',
        'Given the head of a singly linked list, reverse the list and return the new head.',
        'EASY',
        ARRAY['linked-list']
    )
    RETURNING id
)
INSERT INTO test_cases (problem_id, input, expected_output, is_hidden)
SELECT id, '[1,2,3,4,5]', '[5,4,3,2,1]', false FROM new_problem
UNION ALL
SELECT id, '[]', '[]', true FROM new_problem;