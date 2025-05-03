import { Message, User } from "../types/Models";

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

export const fetchFollowedUsers = async (): Promise<User[]> => {
  const response = await fetch(`${API_BASE_URL}/users/following`);
  if (!response.ok) throw new Error("Failed to fetch followed users");
  const data = await response.json();
  console.log("Response:", data);
  return data;
};

export const fetchNonFollowedUsers = async (): Promise<User[]> => {
  const response = await fetch(`${API_BASE_URL}/users/not-following`);
  if (!response.ok) throw new Error("Failed to fetch non-followed users");
  return response.json();
};

export const fetchTimeline = async (): Promise<Message[]> => {
  const response = await fetch(`${API_BASE_URL}/messages/timeline`);
  if (!response.ok) throw new Error("Failed to fetch timeline");
  return response.json();
};

export const fetchUserTimeline = async (username: string) => {
  const response = await fetch(`${API_BASE_URL}/messages/user/${username}`);
  if (!response.ok) throw new Error("Failed to fetch user timeline");
  return response.json();
};

export const postMessage = async (message: string) => {
  const response = await fetch(`${API_BASE_URL}/messages`, {
    method: "POST",
    headers: { "Content-Type": "text/plain" },
    body: message,
  });
  if (!response.ok) throw new Error("Failed to post message");
};

export const followUser = async (username: string) => {
  const response = await fetch(`${API_BASE_URL}/users/follow/${username}`, {
    method: "POST",
  });
  if (!response.ok) throw new Error("Failed to follow user");
};

export const unfollowUser = async (username: string) => {
  const response = await fetch(`${API_BASE_URL}/users/unfollow/${username}`, {
    method: "POST",
  });
  if (!response.ok) throw new Error("Failed to unfollow user");
};
