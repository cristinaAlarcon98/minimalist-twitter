import React, { createContext, useContext, useState, useEffect } from "react";
import {
  fetchFollowedUsers,
  fetchNonFollowedUsers,
  fetchTimeline,
} from "../services/service.ts";
import { AppContextType } from "../types/AppContextType.ts";
import { Message, User } from "../types/Models.ts";

const AppContext = createContext<AppContextType | undefined>(undefined);

export const AppProvider = ({ children }: { children: React.ReactNode }) => {
  const [followedUsers, setFollowedUsers] = useState<User[]>([]);
  const [nonFollowedUsers, setNonFollowedUsers] = useState<User[]>([]);
  const [timeline, setTimeline] = useState<Message[]>([]);
  const [selectedCard, setSelectedCard] = useState<string | null>(null);

  const fetchAllData = async () => {
    try {
      const followedUsers = await fetchFollowedUsers();
      setFollowedUsers(followedUsers);

      const nonFollowedUsers = await fetchNonFollowedUsers();
      setNonFollowedUsers(nonFollowedUsers);

      const timeline = await fetchTimeline();
      setTimeline(timeline);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    fetchAllData();
  }, []);

  return (
    <AppContext.Provider
      value={{
        followedUsers,
        nonFollowedUsers,
        timeline,
        setTimeline,
        fetchAllData,
        selectedCard,
        setSelectedCard,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};

export const useAppContext = () => {
  const context = useContext(AppContext);
  if (!context) {
    throw new Error("useAppContext must be used within an AppProvider");
  }
  return context;
};
