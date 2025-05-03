import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { UserListSectionProps } from "../types/UserListSectionProps.ts";

export const UserListSection: React.FC<UserListSectionProps> = ({
  title,
  users,
  buttonText,
  onButtonClick,
}) => {
  return (
    <Card
      sx={{
        borderRadius: 0,
        border: "1px solid rgb(176, 213, 239)",
        height: "100%",
        overflowY: "auto",
      }}
    >
      <CardContent>
        <Typography
          gutterBottom
          component="div"
          sx={{ fontWeight: "bold", color: "primary.contrast" }}
        >
          {title}
        </Typography>
        {users.map((user) => (
          <div
            key={user.username}
            style={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
              marginBottom: "10px",
            }}
          >
            <Typography sx={{ color: "#657786", fontWeight: "500" }}>
              {user.username}
            </Typography>
            <Button
              variant="contained"
              color="primary"
              size="small"
              onClick={() => onButtonClick(user.username)}
              sx={{
                textTransform: "none",
                fontWeight: "bold",
                backgroundColor: "primary.contrast",
                color: "primary.main",
                "&:hover": { backgroundColor: "#0d8ae0" },
              }}
            >
              {buttonText}
            </Button>
          </div>
        ))}
      </CardContent>
    </Card>
  );
};
