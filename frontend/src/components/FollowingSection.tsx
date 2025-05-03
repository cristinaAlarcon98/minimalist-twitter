import React from "react";
import { useAppContext } from "../context/AppContext.tsx";
import { UserListSection } from "./UserListSection.tsx";
import { unfollowUser } from "../services/service.ts";

export const FollowingSection = () => {
  const { followedUsers, fetchAllData, setSelectedCard } = useAppContext();

  const handleUnfollow = async (username: string) => {
    try {
      await unfollowUser(username);
      await fetchAllData();
      setSelectedCard(null);
    } catch (error) {
      console.error("Error unfollowing user:", error);
    }
  };

  return (
    <UserListSection
      title="Following"
      users={followedUsers}
      buttonText="Unfollow"
      onButtonClick={handleUnfollow}
    />
  );
};
