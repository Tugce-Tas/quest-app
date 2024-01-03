import React, { useState, useEffect } from "react";
import Accordion from 'react-bootstrap/Accordion';
import "@fortawesome/fontawesome-free";
import "./Post.scss"

function PostComment() {
    const [isCommOpen, setIsCommOpen] = useState(false);
    const handleCommentClick = () => {
        const headerElement = document.querySelector(".postComment");
        const commElement = document.querySelector(".comments");
        if (headerElement) {
            commElement.classList.toggle("show-comm");
        }
        setIsCommOpen(!isCommOpen);
    };

    return (
        <div >
            <button>
            <i className="fa-regular fa-comment postComment"></i>
            </button>
            <p className="comments" onClick={handleCommentClick}>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
        minim veniam, quis nostrud exercitation ullamco laboris nisi ut
        aliquip ex ea commodo consequat. Duis aute irure dolor in
        reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
        culpa qui officia deserunt mollit anim id est laborum.
            </p>
            </div>
    )
/*
    return (
        <Accordion defaultActiveKey={['0']} alwaysOpen >
            <Accordion.Item eventKey="0">
                <Accordion.Header className="postComment" onClick={handleCommentClick}>
                    <i className="fa-regular fa-comment"></i></Accordion.Header>
                <Accordion.Body>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                    eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                    aliquip ex ea commodo consequat. Duis aute irure dolor in
                    reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                    pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
                    culpa qui officia deserunt mollit anim id est laborum.
                </Accordion.Body>
            </Accordion.Item>
        </Accordion>
    );

    */
}

export default PostComment;