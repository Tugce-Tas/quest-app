import React, { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import PostComment from "./PostComments";
import "@fortawesome/fontawesome-free";
import "./Post.scss"

function Post(props) {
    const { title, text } = props;

    return (
        <div className="postContainer">
            <Card className="rounded post">
                <Card.Body>
                    <Card.Title>{title}</Card.Title>
                    <Card.Text>
                    {text} - Some quick example text to build on the card title and make up the bulk of the card's content. Some quick example text to build on the card title and make up the bulk of the card's content.
                    </Card.Text>
                    <i className="fa-regular fa-heart"></i>
                    <i className="fa-regular fa-comment"></i>
                    <PostComment></PostComment>
                </Card.Body>
            </Card>
            
        </div>
        
    )
}

export default Post;