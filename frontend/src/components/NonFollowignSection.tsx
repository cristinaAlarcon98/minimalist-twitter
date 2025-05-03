import React from "react";
import { useAppContext } from "../context/AppContext.tsx";
import { UserListSection } from "./UserListSection.tsx";
import { followUser } from "../services/service.ts";

export const NonFollowingSection = () => {
  const { nonFollowedUsers, fetchAllData, setSelectedCard } = useAppContext();

  const handleFollow = async (username: string) => {
    try {
      await followUser(username);
      await fetchAllData();
      setSelectedCard(null);
    } catch (error) {
      console.error("Error following user:", error);
    }
  };

  return (
    <UserListSection
      title="Follow"
      users={nonFollowedUsers}
      buttonText="Follow"
      onButtonClick={handleFollow}
    />
  );
};
