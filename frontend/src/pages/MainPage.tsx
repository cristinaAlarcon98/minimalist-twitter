import React from "react";
import { TimelineSection } from "../components/TimelineSection.tsx";
import { FollowingSection } from "../components/FollowingSection.tsx";
import { PostMessageSection } from "../components/PostMessageSection.tsx";
import "./MainPage.css";
import { NonFollowingSection } from "../components/NonFollowignSection.tsx";
export const MainPage = () => {
  return (
    <div className="main-container">
      <div className="user-section">
        <div className="list-section">
          <FollowingSection />
        </div>
        <div className="list-section">
          <NonFollowingSection />
        </div>
      </div>
      <div className="main-content">
        <div className="timeline">
          <TimelineSection />
        </div>
        <div className="post-section">
          <PostMessageSection />
        </div>
      </div>
    </div>
  );
};
